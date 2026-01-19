describe('Cart & Checkout Tests - Saucedemo', () => {
  beforeEach(() => {
    cy.visit('https://www.saucedemo.com');
    cy.get('#user-name').type('standard_user');
    cy.get('#password').type('secret_sauce');
    cy.get('#login-button').click();
    cy.url().should('include', '/inventory.html');
  });

  it('TC01 - Should add product to cart and verify cart badge', () => {
    cy.get('.inventory_item').first().as('firstProduct');

    cy.get('@firstProduct')
      .find('button.btn_inventory')
      .should('contain', 'Add to cart')
      .click();

    cy.get('.shopping_cart_badge')
      .should('be.visible')
      .and('have.text', '1');
  });

  it('TC02 - Should remove product from cart and badge disappears', () => {
    // Bước 1: Thêm sản phẩm vào giỏ
    cy.get('.inventory_item').first().find('button.btn_inventory').click();
    cy.get('.shopping_cart_badge').should('have.text', '1');

    // Bước 2: Vào trang giỏ hàng
    cy.get('.shopping_cart_link').click();
    cy.url().should('include', '/cart.html');

    // Bước 3: Nhấn nút Remove
    cy.get('.cart_item')
      .should('have.length', 1)
      .find('button.cart_button')
      .should('contain', 'Remove')
      .click();

    // Bước 4: Kiểm tra giỏ hàng trống
    cy.get('.cart_item').should('not.exist');
    cy.get('.shopping_cart_badge').should('not.exist');
  });

  it('TC03 - Should complete checkout step one successfully', () => {
    // Thêm 1 sản phẩm vào giỏ
    cy.get('.inventory_item').eq(1).find('button.btn_inventory').click();

    // Vào giỏ hàng
    cy.get('.shopping_cart_link').click();

    // Nhấn Checkout
    cy.get('[data-test="checkout"]').click();
    cy.url().should('include', '/checkout-step-one.html');
    cy.get('[data-test="firstName"]').type('John');
    cy.get('[data-test="lastName"]').type('Doe');
    cy.get('[data-test="postalCode"]').type('12345');
    cy.get('[data-test="continue"]').click();

    cy.url().should('include', '/checkout-step-two.html');
    cy.get('.checkout_summary_container').should('be.visible');
    cy.get('.summary_info').should('contain', 'Payment Information');
  });
});
# BÀI TẬP MÔN KIỂM THỬ PHẦN MỀM

---
Họ và tên: Trần Tiến Thành
Mã sinh viên: BCS230081

---
## Bài 1: Đánh giá giao diện trên trang Can't Unsee

Hình ảnh kết quả đánh giá giao diện người dùng trên website **Can't Unsee**:
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/649e5fe8-3505-45d1-bcbf-bd51f836bb0c" />
---

## Bài 2: Thực hành kiểm thử đơn vị với JUnit

### 1. Mô tả bài toán

Xây dựng chương trình Java phân tích điểm số của học sinh/lớp học, bao gồm các chức năng chính:

- Đếm số học sinh đạt loại **Giỏi** (điểm trung bình ≥ 8.0)
- Tính điểm trung bình của toàn bộ các điểm hợp lệ (từ 0 đến 10)

**Lưu ý**:
- Các điểm không hợp lệ (< 0 hoặc > 10) sẽ bị bỏ qua
- Nếu danh sách rỗng hoặc không có điểm hợp lệ → trả về `0`

---

### 2. Công nghệ sử dụng

| Thành phần          | Công nghệ                     |
|---------------------|-------------------------------|
| Ngôn ngữ lập trình  | Java                          |
| Kiểm thử đơn vị     | JUnit 5 (JUnit Jupiter)       |
| IDE                 | IntelliJ IDEA / VS Code       |
| Quản lý thư viện    | Maven                         |
| Quản lý mã nguồn    | GitHub                        |

---

### 3. Cấu trúc thư mục dự án
```text
SoftwareTestingAssignment/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── StudentScoreAnalyzer.java
│   └── test/
│       └── java/
│           └── StudentScoreAnalyzerTest.java
├── pom.xml
├── README.md
└── images/
└── cantunsee-result.png
```
---

### 4. Nội dung chính

#### 4.1. Lớp StudentScoreAnalyzer

Lớp chính chịu trách nhiệm xử lý logic nghiệp vụ, gồm 2 phương thức quan trọng:

- `countExcellentStudents(List<Double> scores)` → đếm số học sinh giỏi
- `calculateAverageScore(List<Double> scores)` → tính điểm trung bình các điểm hợp lệ

#### 4.2. Các test case đã thực hiện (JUnit 5)

```java
@ParameterizedTest
@CsvSource({
    "8.5, 9.0, 7.5, 10.0, 1",           // 2 học sinh giỏi
    "6.5, 7.9, 5.0,                  0", // không ai giỏi
    "8.0,                           1", // biên - đúng bằng 8.0
    "                                 0", // danh sách rỗng
    "-1.0, 11.0, 9.5,               1", // có điểm không hợp lệ
    "8.0, 8.0, 8.0,                 3"
})
void testCountExcellentStudents(String scoresStr, int expected) {
    // ... code test
}
```
5. Hướng dẫn chạy dự án

Clone repository

Bashgit clone https://github.com/username/ten-repo-cua-ban.git

Mở dự án bằng IntelliJ IDEA / VS Code
Cài đặt dependencies (nếu dùng Maven)

Bashmvn clean install

Chạy toàn bộ test

Bashmvn test
Hoặc chạy từng test class trong IDE.

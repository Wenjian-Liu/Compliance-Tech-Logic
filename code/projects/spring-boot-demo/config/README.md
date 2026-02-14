# DemoApplication - Compliance Automation Foundation

> **Project Mission**: Establishing a robust, scalable environment for legal-tech automation, starting from extreme system constraints.

---

## 🛠 Environment & Tech Stack
* **Framework**: Spring Boot 2.7.18
* **IDE**: IntelliJ IDEA (Ultimate/Community)
* **JDK**: 1.8+ (LTS)
* **Build Tool**: Maven 3.x

---

## 🏗 Infrastructure Setup (Resilience Record)
*This project was initialized under extreme disk constraints (C: < 100MB). Standard recovery protocols were applied.*

### 1. Storage & Path Migration
To prevent system failure, the **Local Repository** has been migrated and locked to:
- `D:\Java\.m2\repository`

### 2. Network Optimization
Modified `config/settings.xml` with **Aliyun Maven Mirrors** to bypass connectivity issues and ensure build stability.

### 3. Fault Tolerance (Critical Fix)
- **Problem**: `NUL` corrupted `oss-parent-7.pom` due to system crash.
- **Solution**: Performed manual cache purging and enforced `Maven Reload`.
- **Packaging**: Migrated the main class from `default package` to `com.wenjian` to comply with Spring Boot application standards.

---

## 🚦 Getting Started

### How to Run
1. Open the project in **IntelliJ IDEA**.
2. Run `DemoApplication.java`.
3. Wait for the log: `Started DemoApplication in X seconds`.

### Verification
Access the following endpoint to verify system health:
- **URL**: [http://localhost:8080/hello](http://localhost:8080/hello)
- **Expected Output**: `"Hallo Wenjian-liu! C盤空間充足，Spring順利運行！"`

---

## 📂 Project Structure
- `/src`: Application source code.
- `/config`: Critical infrastructure configurations (e.g., `settings.xml`).

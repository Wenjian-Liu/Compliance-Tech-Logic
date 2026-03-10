# RegTech Compliance Engine

### 📌 Project Overview
A modular compliance validation engine designed to bridge the gap between regulatory requirements and technical enforcement. This project implements a **Strategy Pattern** and **Aspect-Oriented Programming (AOP)** to automate financial compliance checks (e.g., AML, limit monitoring) with zero friction to core business logic.

### 🛠 Technical Stack
* **Core:** Java 17, Spring Boot 3.5.11
* **Architecture:** Strategy Pattern (for Rule decoupling), AOP (for performance auditing)
* **Build Tool:** Maven
* **Testing:** JUnit 5 (Focusing on Regulatory Edge Cases)

### ⚖️ Compliance Logic Implementation
* **AmountRule:** Implements threshold monitoring to prevent large-sum transaction risks.
* **CurrencyRule:** Validates restricted currencies (e.g., BTC) to ensure regional regulatory alignment.
* **Performance Aspect:** Automated logging of compliance execution time to meet auditability standards.

# ⚖️ LegalTech Compliance Engine (LCE)
**Bridging the Gap between Legal Manuals and Automated Governance**

## 👤 Developer Profile
Developed by a **Legal Professional** (A-Level Legal Professional Qualification) with **5+ years of MNC legal & compliance experience** (including *Decathlon* and *Kyowa Kirin*).

## 📖 Project Vision
In traditional multinational corporations (MNCs), compliance manuals are static documents prone to human error. This project demonstrates how to **hardcode legal intelligence** into a backend system, ensuring 100% adherence to corporate governance protocols through automated logic.

## 🛠 Tech Stack
* **Framework**: Spring Boot 4.0.2
* **Language**: Java 17 (LTS)
* **Build Tool**: Maven
* **Architecture**: RESTful Web Services

---

## 🛡️ Core Compliance Modules

### 1. ComplianceController (Automated Routing)
**Pain Point**: Eliminates the risk of oversight during manual contract value screening.
* **Endpoint**: `/check`
* **Logic**:
    * `amount > 1,000,000`: Returns warning: "Must be submitted to the General Manager for approval."
    * `amount >= 0`: Returns confirmation: "Legal department filed, proceed with normal approval."
    * **Input Validation**: Rejects invalid amounts with usage instructions.

### 2. AuditController (Risk Auditing)
**Pain Point**: Prevents "rubber-stamping" or superficial reviews for high-value transactions.
* **Endpoint**: `/audit`
* **Logic (Dual-Dimensional Scanning)**:
    * If `amount > 1,000,000` **AND** `days < 3`: The system identifies a high-risk scenario where due diligence may be missing.
    * **Warning**: "Large amount but review took only [X] days. Please re-verify the Due Diligence report!"

---

## 🚀 Professionalism & Scalability
* **Logic Precision**: Translates ambiguous legal terms into explicit Boolean operations (Amount + Time).
* **Audit Trail**: Every automated decision path is traceable via REST endpoints, meeting MNC internal audit requirements.
* **Extensibility**: The modular Controller structure allows for future integration of GDPR data export logic or FCPA vendor blacklists.

---

## 🚦 Verification
Verify the deployed logic via the following sample URLs:
1. **Approval Check**: `http://localhost:8080/check?amount=1200000`
2. **Risk Audit**: `http://localhost:8080/audit?amount=1500000&days=2`

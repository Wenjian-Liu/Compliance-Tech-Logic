# RegTech Compliance Module

## Overview
This module demonstrates a **modular compliance engine** designed for Anti-Money Laundering (AML) scenarios. It translates legal requirements (e.g., transaction limits and restricted currencies) into technical system constraints.

## Key Features
- **Strategy Pattern**: Decoupled compliance logic into reusable `ComplianceRule` components.
- **AOP Monitoring**: Implemented `CompliancePerformanceAspect` to track execution time of compliance checks without polluting business logic.
- **Robust Validation**: Uses custom `ComplianceViolationException` for structured error handling.
- **Test-Driven**: Verified with JUnit 5, including parameterized tests for edge-case scenarios.

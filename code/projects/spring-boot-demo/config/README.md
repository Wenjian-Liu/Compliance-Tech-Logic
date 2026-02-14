Environment Resilience Note:

This project was initialized under extreme disk constraints (C: < 100MB). To ensure system stability and build efficiency:

​Storage Migration: Relocated Local Repository to D:/Java/.m2/repository.
​Network Optimization: Configured Aliyun mirrors in settings.xml to bypass connectivity issues.
​Fault Tolerance: Documented the fix for NUL corrupted POM files caused by system crashes.

#DemoApplication - 合規自動化開發環境起點#

​這是基於 Spring Boot 2.7.18 構建的首個 Web 項目，標誌著從本地語言學習轉向分佈式系統架構的開始。

​1. 環境依賴 (Environment Context)

​IDE: IntelliJ IDEA

​JDK: 1.8+ (與 Spring Boot 2.7.x 兼容)

​Framework: Spring Boot 2.7.18

​Build Tool: Maven 3.x

​2. Maven 配置指南 (Infrastructure Setup)

​為避免系統盤（C盤）空間耗盡並提升依賴下載速度，本項目採用自定義 Maven 配置：

​本地倉庫 (Local Repository): D:\Java\.m2 epository

​配置文件 (Settings): D:\Java\.m2\settings.xml

​鏡像加速: 配置了 Aliyun Maven Mirror 以解決跨境網絡環境下的依賴下載超時問題。

​3. 故障排除記錄 (Bug Fix Log)

​依賴損壞修復: 針對系統崩潰導致的 oss-parent-7.pom 文件 NUL 損壞問題，通過手動清理本地倉庫緩存並執行 Maven Reload 成功恢復。

​路徑規範: 修正了啟動類位於 default package 的結構錯誤，將核心代碼規範化遷移至 com.wenjian 包下。

​4. 如何啟動與訪問

​在 IDEA 中運行 DemoApplication.java。

​待控制台顯示 Started DemoApplication 後，訪問以下接口：

​接口地址: http://localhost:8080/hello

​預期返回: "Hallo Wenjian-liu! C盤空間充足，Spring順利運行！"

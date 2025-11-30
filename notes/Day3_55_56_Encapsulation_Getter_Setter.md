# Day3 OOP学习：封装 + Getter & Setter

### 🔐 封装的作用
- 隐藏内部数据，只暴露必要方法
- 防止外部随意修改属性（例如薪资为负数）
- 提高安全性、降低耦合

### 🧱 Getter / Setter 作用
- getXxx()：安全读取属性
- setXxx()：校验后再修改属性
- 示例：不允许设置负数薪资

### 🧪 今日练习
- Employee 私有属性：baseSalary / bonus
- Setter 校验 baseSalary ≥ 0
- Getter 用于打印查询工资
- SalaryDemo 演示实际调用

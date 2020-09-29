#操作符
---
别名现象：Tank.java

& 与运算：均为1则出1，其余为0  
| 或运算：有1出1，均为0则出0 
^ 异或：同为0，异为1   
~ 非运算：按位取反

布尔类型作为一种单比特值对待，可对其与或异或运算，但不能对其执行非运算，为了避免与逻辑NOT混淆

如果对char,byte,short进行移位处理，那么在移位之前会被转换成int类型，并且得到的值也是int类型，如果对long类型进行数值处理，最后得到的也是long类型

注意窄化转换的截尾与舍入

布尔类型不允许与任何类型进行转换
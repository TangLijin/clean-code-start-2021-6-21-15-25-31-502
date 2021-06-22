## Code Smell in $7_long_method

#### Useless Comment
例如在OrderReceipt类中的

`// print date, bill no, customer name
//        output.append("Date - " + order.getDate();`

#### Naming
例如OrderReceipt类中的属性Order o

#### Magic Number or String
.10 和 "Total Amount"等;

#### Long Method
printReceipt()方法

#### Feature Envy
计算税和订单总金额应该放到Order类中进行


Java Mail和Freemarker结合Demo

>引入基本的Spring MVC依赖包，引入mail，activation和freemarker包

注意：

1. 需要事先在EmailUtil类中设置好你的发送邮件地址以及SMTP主机，用户名和密码。

2. 本demo单纯使用Java Mail处理邮件，有些繁琐，具体使用时可以引入Spring Mail插件

问题：

1. javax.mail.AuthenticationFailedException: 530 Error， 在Email.java中sendBatch方法添加properties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接。

2. com.sun.mail.smtp.SMTPSendFailedException: 501 mail from address，在EmailUtil类中设置发送邮箱为当前授权的邮箱，如果是用你的qq邮箱做授权，那就添加你的邮箱账号

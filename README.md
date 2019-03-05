# jks-core
Abstract encapsulation of JKS

## 如何使用

### 生成证书容器

### 生成自签证书

### 证书导出容器

### 证书导入容器

### 证书签名防篡改

### 使用国家时间戳

### 签署字符串

````java
    public void testSignString () {
        if (debug) {
            JksCore jksCore = new JksCore();
            StringSigner stringSigner = new StringSigner();
            StringSignerRequire stringSignerRequire = new StringSignerRequire();
            stringSignerRequire.setContent("hello world, 你好呀世界")
                    .setPdfPath(this.savepath + "/test.pdf")
                    .setResultPath(this.savepath + "/test_result.pdf")
                    .setFirstX(50)
                    .setFirstY(50)
                    .setPage(1)
                    .setFontSize(12);
            JSONObject result = jksCore.doJob(stringSigner, stringSignerRequire);
            System.out.println(result.toJSONString());
        }
    }

    public void testBase64SignString () throws IOException {
        if (debug) {
            JksCore jksCore = new JksCore();
            Base64StringSigner base64StringSigner = new Base64StringSigner();
            Base64StringSignerRequire base64StringSignerRequire = new Base64StringSignerRequire();
            base64StringSignerRequire.setContent("hello world , 你好呀你好呀")
                    .setPdfBase64(Base64FileTool.filePathToBase64(savepath + "/test.pdf"))
                    .setFirstX(100)
                    .setFirstY(100)
                    .setPage(1)
                    .setFontSize(12);
            JSONObject result = jksCore.doJob(base64StringSigner, base64StringSignerRequire);
            Base64FileTool.saveBase64File(result.get("content").toString(), savepath + "/test_result_2.pdf");
        }
    }
````
## 常见错误

* 如果在写入pfx证书到jks容器中，产生illegal key size的异常，那么多半是证书密码的问题，最好限定为6位有效数字。



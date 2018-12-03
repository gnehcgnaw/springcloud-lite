1. [http://localhost:48081/oauth/authorize?response_type=code&client_id=client&redirect_uri=http://baidu.com]()

    username:admin
    password:123456

2. [https://www.baidu.com/?code=G1fs4d]()

3. post请求：[http://localhost:48081/oauth/token?client_id=client&grant_type=authorization_code&redirect_uri=http://baidu.com&code=G1fs4d]()

    username:client
    password:secret
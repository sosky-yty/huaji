<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>登录界面</title>
    <meta name="keywords" content="图书馆管理">
    <meta name="description" content="Spring Boot开发项目">
    <link rel="stylesheet" href="${ContextPath!}/css/login.css">
    <link rel="stylesheet" href="${ContextPath!}/css/bootstrap.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>

    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="${ContextPath!}/js/bootstrap.js"></script>
    <script src="${ContextPath!}/js/vue.js"></script>
    <script src="${ContextPath!}/js/untils/storage.js"></script>
    <script src="${ContextPath!}/js/untils/router.js"></script>

    <#--异步通信库-->
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
    <#--导入网络通信库-->
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="${ContextPath!}/gt/gt.js"></script>

</head>

<body>
    <div class="container-wapper" id="vue">
        <div class="title">
            <h2 style="color: #005cbf; padding-top:50px;">滑稽图书馆</h2>
        </div>
        <div class="login-area">
            <h4 style="color: #5c81e3; padding-bottom: 20px; position: center;: center">使用滑稽账号登录图书馆</h4>
            <ul class="common-form">
                <li class="username">
                    <div class="input">
                        <input type="text"  v-model="userName" placeholder="账号">
                    </div>
                </li>
                <li>
                    <div class="input">
                        <input type="text" v-model="userPwd" placeholder="密码">
                    </div>
                </li>
                <li>
                    <div id="captcha">
                        <p id="wait" style>正在加载验证码...</p>
                    </div>
                </li>
                <li style="text-align: right margin-right: 20px" class="pr"><el-checkbox class="auto-login" v-model="autoLogin">记住密码</el-checkbox>
                    <a href="register.ftl" class="register">注册滑稽账号</a>
                    <a style="padding: 1px 0 0 10px;" href="forget">忘记密码?</a>
                </li>
            </ul>
            <div style="margin-top: 25px; position: center;">
                <button  @click="login" :class="logintxt === '登录'? 'main-btn':'disable-btn'" >{{logintxt}}</button>
            </div>
        </div>
    </div>
</body>
<script src="${ContextPath!}/js/public.js"></script>
<script src="${ContextPath!}/js/api.js"></script>
<script>
    var captcha;
         new Vue({
        el: '#vue',
        data: {
            autoLogin:false ,
            logintxt:'登录',
            userName:'',
            userPwd:'',
            statusKey:''
        },
        methods:{
            open (t, m) {
                this.$notify.info({
                    titile: t,
                    message: m
                })
            },
            messageSuccess () {
                this.$message({
                    message: '恭喜你，注册成功！赶紧登录体验吧',
                    type: 'success'
                })
            },
            message (m) {
                this.$message.error({
                    message: m
                })
            },
            rememberPass(){
              if (this.logintxt === true) {
                  setStore('remember','true');
                  setStore('rusername',this.userName);
                  setStore('ruserpwd',this.userPwd);
              } else {
                  setStore('remember','false');
                  removeStore('rusername');
                  removeStore('ruserpwd');
              }
            },
            getRemember(){
                var judge = getStore('remember');
                if (judge === 'true'){
                    this.autoLogin = true;
                    this.userName = getStore('rusername');
                    this.userPwd = getStore('ruserpwd');
                }
            },
            login(){
                this.logintxt = '登录中...';
                this.rememberPass();
                if (!this.userName || !this.userPwd) {
                    this.message("账号密码不能为空！");
                    this.logintxt = '登录';
                    return false;
                }
                var result =  captcha.getValidate();
                if (!resule) {
                    this.message("请先完成登录！");
                    this.logintxt = '登录';
                    return false;
                }
                var params = {
                    userNama:this.userNama,
                    userPwd:this.userPwd,
                    challenge: result.geetest_challenge,
                    validate: result.geetest_validate,
                    seccode: result.geetest_seccode,
                    statusKey: this.statusKey
                }
                userLogin(params).then(res=>{
                    if (res.result.state === 1){
                        this.open("暂且算你登录成功了，后台接口还没写")
                    }else{
                        this.logintxt = '登录';
                        this.message(res.result.message);
                        captcha.reset();
                        return false;
                    }
                })
            },
            init_geetest(){
                geetest().then(res => {
                    this.statusKey = res.statusKey;
                    data = JSON.parse(res);
                    window.initGeetest({
                        gt: data.gt,
                        challenge: data.challenge,
                        new_captcha: true,
                        offline: !data.success,
                        product: 'popup',
                        width: '100%'
                    }, function (captchaObj) {
                        captcha = captchaObj;
                        captchaObj.appendTo('#captcha');
                        captchaObj.onReady(function () {
                            document.getElementById('wait').style.display = 'none'
                        })
                    })
                })
            }
        },
        mounted(){
         this.getRemember();
         this.init_geetest();
         this.open("登录提示","测试账号： admin | admin")
        },
        attached(){
            this.init_geetest();
        }
    });

</script>
</html>
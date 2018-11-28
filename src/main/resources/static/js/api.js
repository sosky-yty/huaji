
// 用户登录
const userLogin = (params) =>{
    return Post('/login',params);
};

// 退出登录
const loginOut = (params) =>{
    return Post('/loginOut',params);
};

// 用户信息
const userInfo = (params) =>{
    return Get('/userInfo',params);
};

// 用户注册
const register = (params) =>{
    return Post('/register',params);
};

// 验证码
const geetest = (params) =>{
    return Get('geetestInit?t=' + (new Date()).getTime(),params);
};

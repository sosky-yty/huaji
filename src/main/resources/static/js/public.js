
axios.defaults.timeout = 10000;
axios.defaults.headers.post['Content-Type'] = 'application/x-www=form-urlencoded';
/**
 * Promise为代理对象
 * pending: 初始状态，既不是成功，也不是失败状态。
 *fulfilled: 意味着操作成功完成。
 rejected: 意味着操作失败。
 resolve()返回的是Promise对象，调用then方法进行后续操作
 见于https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Promise
 */

function Get(url,params={}){
    return new Promise((resolve, reject) => {
        axios.get(url, params).then(res => {
            resolve(res.data)
        }).catch(error => {
            reject(error)
        })
    })
}

function Post (url, params = {}) {
        return new Promise((resolve, reject) => {
            axios.post(url, params).then(res => {
                resolve(res.data)
            }).catch(error => {
                reject(error)
            })
        })
}

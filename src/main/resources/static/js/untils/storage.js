
 const setStore = (name,content) =>{
    if (!name) return;
    if (typeof content !== 'string') {
        content = JSON.stringify(content)
    }
    window.localStorage.setItem(name, content)
}

/**
 * 取出值
 * @param {*} name 键
 */
 const getStore = name => {
    if (!name) return
    return window.localStorage.getItem(name)
}

/**
 * 删除存储
 * @param {*} name
 */
 const removeStore = name => {
    if (!name) return
    window.localStorage.removeItem(name)
}

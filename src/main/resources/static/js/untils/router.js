const push = (path) => {
    if (typeof path !== "string") return;
    window.location.href= path
}
const newtab = (path) =>{
    if (typeof path !== "string") return;
    window.open(path)
}
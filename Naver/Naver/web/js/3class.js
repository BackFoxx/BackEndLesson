var a = [1, 2, 3, 4, 4];
var b = [...a, 44, 343];
console.log(a.length);
console.log(a[440]);

console.log(b);

b.forEach((v,i,o) => {
    console.log(v);
})

const mapped = b.map((v) => {
    return v * 2;
})

console.log(mapped);

const obj = {
    key: "value",
    addition: "minecraft"
}

console.log(obj.key);
console.log(obj["addition"]);

console.log(Object.keys(obj));
Object.keys(obj).forEach(value => {
    console.log(obj[value]);
})
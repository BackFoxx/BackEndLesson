const data = {
    "debug": "on",
    "window": {
        "title": "Sample Konfabulator Widget",
        "name": "main_window",
        "width": 500,
        "height": 500
    },
    "image": {
        "src": "Images/Sun.png",
        "name": "sun1",
        "hOffset": 250,
        "vOffset": 250,
        "alignment": "center"
    },
    "text": {
        "data": "Click Here",
        "size": 36,
        "style": "bold",
        "name": "text1",
        "hOffset": 250,
        "vOffset": 100,
        "alignment": "center",
        "onMouseUp": "sun1.opacity = (sun1.opacity / 100) * 90;"
    }
}

var array = [];
for (const dataKey in data) {
    const D = data[dataKey];
    if (typeof D === "object") {
        for (const dKey in D) {
            if (typeof D[dKey] === 'number') {
                array.push(dKey);
            }
        }
    } else if (typeof D === "number") {
        array.push(D)
    }
}

console.log(array);
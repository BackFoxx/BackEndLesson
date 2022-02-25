const element = document.querySelector('ul');
element.insertAdjacentHTML("beforeend", "<li>새 과일1</li>");

const element1 = document.createElement('li');
const node = document.createTextNode('새 과일2');
element1.appendChild(node);

element.insertBefore(element1, element.childNodes.item(5));


/**
 * Created by PC on 2022-03-11.
 */

import { LightningElement } from 'lwc';
export default class HelloWorld extends LightningElement {
    greeting = 'World';
    changeHandler(event) {
        this.greeting = event.target.value;
    }
}
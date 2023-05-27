import BaseComponent from "../../../common/base-component";

class Form extends BaseComponent {
    show () {
        this.getElement() && this.getElement().classList.remove('form--hidden');
    }

    hide () {
        this.getElement() && this.getElement().classList.add('form--hidden');
    }

    onClickCloseButton (fn) {
        this.getElement() && this.getElement().querySelector('.form__close-button').addEventListener('click', fn);
    }
}

export default Form;
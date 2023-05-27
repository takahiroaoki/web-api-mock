import BaseComponent from "../../../common/base-component";

class CreateButton extends BaseComponent {
    onClick (fn) {
        this.getElement() && this.getElement().addEventListener('click', (e) => {
            e.stopPropagation();
            fn();
        });
        return this;
    }
}

export default CreateButton;
class BaseComponent {
    /**
     * @param {String} componentId 
     */
    constructor (componentId) {
        this._element = document.querySelector(`[componentid=${componentId}]`);
        this._init();
    }

    /**
     * Initialize the component. Override this method in each sub-class.
     */
    _init () {}

    /**
     * @returns {Element} Element
     */
    getElement () {
        return this._element;
    }
}

export default BaseComponent;
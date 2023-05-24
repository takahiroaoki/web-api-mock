import CreateButton from './components/create-button/create-button';
import Form from './components/form/form';
import './index.scss';

const index = () => {
    // mount components
    const createButton = new CreateButton('create-button');
    const form = new Form('form');

    // setting
    createButton.onClick(() => {
        form.show();
    });
    form.onClickCloseButton(() => {
        form.hide();
    });
};

index();
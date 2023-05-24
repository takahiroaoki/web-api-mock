import CreateButton from './components/create-button/create-button';
import './index.scss';

const index = () => {
    // mount components
    const createButton = new CreateButton('create-button');

    // setting
    createButton.onClick(() => {
        console.log("The button has been clicked.");
    });
};

index();
"use strict";
const deleteUserHandler = function (element) {
    const fullName = element.getAttribute('data-fullName');
    const confirmModal = new ConfirmModal('#confirm-operation-modal');
    confirmModal.title = 'Confirm operation';
    confirmModal.content = `Are you sure to permanently remove ${fullName}?`;

    const confirmHandler = function () {
        const form = element.closest('form');
        form.submit();
    }
    confirmModal.setConfirmHandler(confirmHandler);
    confirmModal.show();
}


class ConfirmModal {

    modal;
    contentElement;
    modalTitle;
    confirmBtn;
    cancelBtn;

    constructor(selector) {
        const modalElement = document.querySelector(selector);
        this.modal = new bootstrap.Modal(modalElement);
        this.contentElement = document.getElementById('confirm-modal-message');
        this.modalTitle = document.getElementById('modal-title');
        this.confirmBtn = document.getElementById('confirm-btn');
        this.cancelBtn = document.getElementById('cancel-btn');
    }


    set title(titleString) {
        this.modalTitle.innerText = titleString;
    }

    set content(contentString) {
        this.contentElement.innerText = contentString;
    }

    show() {
        this.modal.show();
    }

    setConfirmHandler(handler, capture = false) {
        console.log(this.confirmBtn)
        this.confirmBtn.addEventListener('click', handler, {capture: capture})
    }
}

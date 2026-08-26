document.addEventListener("DOMContentLoaded", () => {

    const buttons = document.querySelectorAll("[data-password-toggle]");

    buttons.forEach((button) => {

        button.addEventListener("click", () => {

            const targetId = button.dataset.passwordTarget;
            const input = document.getElementById(targetId);

            if (!input) {
                return;
            }

            const passwordVisible = input.type === "text";

            input.type = passwordVisible
                ? "password"
                : "text";

            button.setAttribute(
                "aria-label",
                passwordVisible
                    ? "Mostrar senha"
                    : "Ocultar senha"
            );

            button.classList.toggle(
                "password-visible",
                !passwordVisible
            );

        });

    });

});
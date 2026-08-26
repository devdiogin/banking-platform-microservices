<#ftl output_format="HTML" auto_esc=true>

<!DOCTYPE html>

<html lang="pt-BR">

<head>

    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0"
    >

    <title>Spring Bank</title>

</head>

<body
    style="
        margin: 0;
        padding: 0;
        background-color: #071A14;
        font-family: Arial, Helvetica, sans-serif;
    "
>

<table
    role="presentation"
    width="100%"
    cellspacing="0"
    cellpadding="0"
    border="0"
    style="
        width: 100%;
        background-color: #071A14;
    "
>

<tr>

<td
    align="center"
    style="
        padding: 48px 20px;
    "
>

<table
    role="presentation"
    width="100%"
    cellspacing="0"
    cellpadding="0"
    border="0"
    style="
        width: 100%;
        max-width: 560px;
    "
>

<tr>

<td
    style="
        padding-bottom: 32px;
        color: #F4F7F5;
        font-size: 18px;
        font-weight: 700;
    "
>

    <span
        style="
            display: inline-block;
            width: 32px;
            height: 32px;
            line-height: 32px;

            margin-right: 8px;

            border-radius: 9px;

            text-align: center;

            background-color: #0F6B46;
            color: #FFFFFF;

            font-size: 15px;
        "
    >
        S
    </span>

    Spring Bank

</td>

</tr>


<tr>

<td
    style="
        padding:
            42px
            38px;

        border:
            1px solid
            #274238;

        border-radius: 18px;

        background-color: #0D241C;
    "
>

<h1
    style="
        margin:
            0
            0
            18px;

        color: #F4F7F5;

        font-size: 30px;
        line-height: 1.15;

        font-weight: 600;

        letter-spacing: -0.8px;
    "
>
    Sua conta está quase pronta.
</h1>


<p
    style="
        margin:
            0
            0
            30px;

        color: #9BAAA3;

        font-size: 15px;
        line-height: 1.7;
    "
>
    Confirme seu e-mail e crie sua senha para concluir
    seu acesso ao Spring Bank.
</p>


<table
    role="presentation"
    cellspacing="0"
    cellpadding="0"
    border="0"
>

<tr>

<td
    style="
        border-radius: 12px;
        background-color: #0F6B46;
    "
>

<a
    href="${link}"
    style="
        display: inline-block;

        padding:
            16px
            26px;

        color: #FFFFFF;

        text-decoration: none;

        font-size: 14px;
        font-weight: 600;

        border-radius: 12px;
    "
>
    Ativar minha conta
</a>

</td>

</tr>

</table>


<p
    style="
        margin:
            30px
            0
            0;

        color: #718078;

        font-size: 12px;
        line-height: 1.6;
    "
>
    Este link é temporário e expira em
    ${linkExpirationFormatter(linkExpiration)}.
</p>


<div
    style="
        height: 1px;

        margin:
            30px
            0;

        background-color: #274238;
    "
></div>


<p
    style="
        margin: 0;

        color: #718078;

        font-size: 12px;
        line-height: 1.6;
    "
>
    Se você não solicitou este acesso,
    pode ignorar este e-mail com segurança.
</p>

</td>

</tr>


<tr>

<td
    align="center"
    style="
        padding-top: 28px;

        color: #718078;

        font-size: 11px;
        line-height: 1.6;
    "
>

    🔒 Ambiente seguro Spring Bank

    <br>

    Este é um e-mail automático. Não responda.

</td>

</tr>

</table>

</td>

</tr>

</table>

</body>

</html>
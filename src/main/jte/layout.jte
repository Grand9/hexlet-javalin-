<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>@{title}</title>
</head>
<body>
<!-- Верхнее меню -->
<header>
    <nav>
        <ul>
            <li><a href="/">Главная</a></li>
            <li><a href="/courses">Курсы</a></li>
        </ul>
    </nav>
    <h1>Grand9</h1>
</header>

<!-- Контент страницы -->
<main>
    @content
</main>

<!-- Футер -->
<footer>
    <p>© 2024. <a href="https://github.com/Grand9">Ваш профиль на GitHub</a></p>
</footer>
</body>
</html>

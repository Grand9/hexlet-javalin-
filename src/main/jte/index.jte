@param exercise.dto.MainPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
</head>
<body>
<main>
    <h1>Привет, Хекслет!</h1>
    @if(page.getCurrentUser() != null)
        Добро пожаловать, ${page.getCurrentUser()}.
        Чтобы разлогиниться, удалите куку JSESSIONID из браузера
    @endif
    <a href="${org.example.hexlet.NamedRoutes.sessionsBuildPath()}">Login</a>
</main>
</body>
</html>


@import gg.jte.Content
@param List<User> users

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Users List</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="/">Главная страница</a></li>
            <li><a href="/users">Все пользователи</a></li>
        </ul>
    </nav>
</header>
<main>
    <h1>Список пользователей</h1>
    @if(users.isEmpty())
        <p>Нет пользователей в системе</p>
    @else
        @for(var user : users)
            <div>
                <p>ID: ${user.getId()}</p>
                <p>Имя: ${user.getFirstName()} ${user.getLastName()}</p>
                <p>Email: ${user.getEmail()}</p>
            </div>
        @endfor
    @endif
</main>
<footer>
    <p>&copy; 2023 My Website. Developed by <a href="https://github.com/Grand9">Grand9</a>.</p>
</footer>
</body>
</html>

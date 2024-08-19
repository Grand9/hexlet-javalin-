@template.layout("layout.jte")
@params(page org.example.hexlet.CoursesPage)

<h2>@page.header</h2>
<ul>
    @for (course : page.courses) {
    <li><a href="/courses/@{course.id}">@{course.name}</a></li>
    }
</ul>

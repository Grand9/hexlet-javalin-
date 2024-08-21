@import exercise.dto.courses.BuildCoursePage
@param BuildCoursePage page

@if(page.getErrors() != null)
    <ul>
        @for(var validator : page.getErrors().values())
            @for(var error : validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif

<form action="/courses" method="post">
    <div>
        <label>
            Название курса
            <input type="text" name="name" value="${page.getName()}" />
        </label>
    </div>
    <div>
        <label>
            Описание курса
            <textarea name="description">${page.getDescription()}</textarea>
        </label>
    </div>
    <input type="submit" value="Создать курс" />
</form>

<h1>All Books</h1>
<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Year</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.year}</td>
            <td>
                <form action="/add-book" method="post">
                    <input type="hidden" name="title" value="${book.title}" />
                    <input type="hidden" name="author" value="${book.author}" />
                    <input type="hidden" name="year" value="${book.year}" />
                    <button type="submit">Add to My Books</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

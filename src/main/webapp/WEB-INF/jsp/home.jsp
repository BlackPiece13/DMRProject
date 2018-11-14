<%@include file="head.jsp"%>
<body>
	<div class="container-fluid">
		<div class="row">
			<%@include file="navbar.jsp"%>
		</div>

		<c:forEach items="${books}" var="book">
			<div class="row" id="media-row-${book.id}">
				<div class="col-sm-3" id="image-col">
					<img alt="image" src="static/livre.png" class="img-responsive"
						id="image-${book.id}" style="width: 100%">
				</div>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-sm-6">
							<h2>${book.title}</h2>
						</div>
						<div class="col-sm-6">

							<h3 style="font-style: italic">${book.author}</h3>
						</div>
					</div>
					<div class="row">
						<div class="well">
							<p>${book.resume}</p>
						</div>
					</div>
					<c:if test="${user.role=='admin'}">
						<div class="row">
							<div class="col-sm-2">
								<button type="button" class="alter btn btn-warning btn-sm"
									id="alter-button-${book.id}">
									<span class="glyphicon glyphicon-search"></span> Modifier
								</button>
							</div>
							<div class="col-sm-2">
								<button type="button"
									class="remove-button btn btn-danger btn-sm"
									id="remove-button-${book.id}">
									<span class="glyphicon glyphicon-search"></span> Supprimer
								</button>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>

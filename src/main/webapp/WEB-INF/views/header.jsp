<!--::header part start::-->
<header class="main_menu home_menu">
	<div class="container">
		<div class="row align-items-center justify-content-center">


			<div class="col-lg-12">
				<nav class="navbar navbar-expand-lg navbar-light">
					<a class="navbar-brand" href="index"> <img src="/img/logo.png" alt="logo"> </a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
							data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
							aria-expanded="false" aria-label="Toggle navigation">
						<span class="menu_icon"><i class="ti-menu"></i></span>
					</button>

					<div class="collapse navbar-collapse main-menu-item" id="navbarSupportedContent">
						<ul class="navbar-nav">
							<li class="nav-item">
								<a class="nav-link" href="index">Home</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="about">about</a>
							</li>
							<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" href="blog" id="navbarDropdown_1"
								   role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									product
								</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
									<a class="dropdown-item" href="productlist"> product list</a>
									<a class="dropdown-item" href="single-product">product details</a>

								</div>
							</li>
							<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" href="blog" id="navbarDropdown_3"
								   role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									pages
								</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
									<a class="dropdown-item" href="login">
										login

									</a>
									<a class="dropdown-item" href="checkout">product checkout</a>
									<a class="dropdown-item" href="cart">shopping cart</a>
									<a class="dropdown-item" href="confirmation">confirmation</a>
									<a class="dropdown-item" href="elements">elements</a>
								</div>
							</li>

							<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" href="blog" id="navbarDropdown_2"
								   role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									blog
								</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
									<a class="dropdown-item" href="blog"> blog</a>
									<a class="dropdown-item" href="single-blog">Single blog</a>
								</div>
							</li>

							<li class="nav-item">
								<a class="nav-link" href="contact">Contact</a>
							</li>
						</ul>
					</div>
					<div class="hearer_icon d-flex align-items-center">
						<a id="search_1" href="javascript:void(0)"><i class="ti-search"></i></a>
						<a href="cart">
							<i class="flaticon-shopping-cart-black-shape"></i>
						</a>
						<a id="logout" href="${contextPath}/logout" data-toggle = "tooltip" title = "Logout"><i style="color: red!important"  class="ti-power-off " ></i></a>
						<span class="label pull-center welcome-message p-2">
							Welcome ${sessionScope.welcomeMessage}!
						</span>

					</div>
				</nav>
			</div>
		</div>
	</div>
	<div class="search_input" id="search_input_box">
		<div class="container ">
			<form class="d-flex justify-content-between search-inner">
				<input type="text" class="form-control" id="search_input" placeholder="Search Here">
				<button type="submit" class="btn"></button>
				<span class="ti-close" id="close_search" title="Close Search"></span>
			</form>
		</div>
	</div>
</header>
<!-- Header part end-->

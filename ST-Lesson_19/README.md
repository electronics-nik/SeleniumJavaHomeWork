# ST-Lesson_19

Software-Testing.Ru LMS<br />
Группа: sel-1<br />
<h2>Задание 19. Реализовать многослойную архитектуру</h2>

**Переделайте созданный в задании 13 сценарий для добавления товаров в корзину и удаления товаров из корзины, чтобы он использовал многослойную архитектуру.**

А именно, выделите вспомогательные классы для работы с главной страницей (откуда выбирается товар), для работы со страницей товара (откуда происходит добавление товара в корзину), со страницей корзины (откуда происходит удаление), и реализуйте сценарий, который не напрямую обращается к операциям Selenium, а оперирует вышеперечисленными объектами-страницами.
# ST-Lesson_18

Software-Testing.Ru LMS<br />
Группа: sel-1<br />
<h2>Задание 18. Перенаправьте трафик в прокси-сервер</h2>

**Установите какой-нибудь прокси-сервер, который умеет протоколировать запросы и ответы.**

На выбор прокси-сервера для разных платформ:

[Progress Telerik](http://www.telerik.com/fiddler) (Windows)<br />
	![Progress Telerik](http://hicomm.bg/web/files/articles_gallery/201605/46532/thumb640x320_13221099_10154255307853987_7023021618539832385_n.png)

[Charles](https://www.charlesproxy.com) (Windows, Linux, MacOS, платный, но есть пробная версия)<br />
	![Charles](http://charles-proxy.ru/images/index/charles1.jpg)

[mitmproxy](https://mitmproxy.org) (Linux, MacOS)<br />
	![mitmproxy](https://mitmproxy.org/images/mitmproxy.png)

[OWASP Zed Attack Proxy (ZAP)](https://www.owasp.org/index.php/OWASP_Zed_Attack_Proxy_Project) (Windows, LInux, MacOS)<br />
	![OWASP Zed Attack Proxy (ZAP)](http://2.bp.blogspot.com/-LHPP71B2jx8/VPtCuFGaZqI/AAAAAAAAB6U/360rxB0w6qo/s1600/zaproxy-logo.png)

Инициализируйте драйвер так, чтобы запросы из браузера отправлялись через этот прокси-сервер, убедитесь, что они там видны.
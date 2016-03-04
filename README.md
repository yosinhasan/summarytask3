# Summary Task 3
<h1>Создать файл XML (input.xml) и соответствующую ему схему XSD (input.xsd).</h1>
<ul>
<li>При разработке XSD обязательно использовать: простые и составные типы, перечисления, шаблоны и предельные значения.</li>
<li>Создать Java-класс, соответствующий данному описанию.</li>
<li>Создать Java-приложение (точка входа - класс Main в корневом пакете) для разбора XML-документа и инициализации контейнера объектов информацией из XML-файла. Для разбора использовать: SAX, StAX парсеры, а также DOM анализатор (все три варианта).</li>
<li>Определить методы, которые будут сортировать объекты контейнера с использованием интерфейса Comparator по некоторому параметру или набору параметров (три парсера => три варианта сортировки => три метода).</li>
<li>Произвести проверку XML-документа на валидность относительно XSD (с помощью валидирующего парсера или validation API).
<li>Определить метод сохранения информации из контейнера в XML-документ.</li>
<li>Входными данными приложения являются имена двух файлов: XML-документа и XSD-документа; выходными данными - три XML файла.</li>
<li>Имена входных файлов задавать параметрами командной строки (если валидирование будет происходить относительно схемы, обозначенной внутри XML-документа, то параметр один - имя XML-файла).</li>
<li>Для демонстрации работы приложения в корневом пакете создать класс Demo, который вызывает метод Main.main вашего приложения с соответствующим значением параметров командной строки:</li> 
</ul>
<p>
Компьютеры.
Компьютерные комплектующие имеют следующие характеристики:
Name - название комплектующего.
Origin - страна производства.
Price - цена (0 - n рублей).
Type (должно быть несколько) - периферийное либо нет, энергопотребление (ватт), наличие кулера (есть либо нет), группа комплектующих (устройства ввода-вывода, мультимедийные), порты (COM, USB, LPT).
Critical - критично ли наличие комплектующего для работы компьютера.
Элемент назвать Device.
</p>

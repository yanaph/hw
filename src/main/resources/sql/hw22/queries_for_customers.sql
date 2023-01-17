-- выбрать все записи с firstName начинающимся с А
SELECT * FROM customer WHERE firstName LIKE 'A%';

-- - выбрать все записи по стране Ukraine
SELECT * FROM customer WHERE country = 'Ukraine';

-- - выбрать все записи с полом male
SELECT * FROM customer WHERE sex = 'male';

-- - обновить страну у всех записей с date of birth до 2000 года на USA
UPDATE customer SET country = 'USA' WHERE YEAR(dateOfBirth) < 2000;

-- - удалить все записи со страной Russia
DELETE FROM customer WHERE country = 'Russia';

-- - выбрать все имена, убрать повторяющиеся (если Alex встречается дважды - в выборке
-- должен быть только 1 Alex)
SELECT firstName FROM customer GROUP BY firstName;

-- - выбрать все записи, отсортировать по дате рождения по убыванию.
SELECT * FROM customer ORDER BY dateOfBirth DESC;
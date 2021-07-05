# Мини-проект по учебной практике

**Состав бригады:**
Павлов Дмитрий, Скворчевский Богдан, Ефимов Максим

**Роли**
1. Павлов Дмитрий: Разработка графического интерфейса, тестировка
2. Сковрчевский Богдан: Разработка алгоритма, тестировка
3. Ефимов Максим: Связь между графическим интерфейсом и логикой программы, тестировка

**Цель:** Разработать программу с графическим интерфейсом на языке программирования Java для визуализации работы алгоритма Дейкстры.

**Описание Алгоритма:** 

В начале алгоритма расстояние для начальной вершины полагается равным нулю, а все остальные расстояния заполняются большим положительным числом (бо́льшим максимального возможного пути в графе). Массив флагов заполняется нулями. Затем запускается основной цикл.

На каждом шаге цикла мы ищем вершину *v* с минимальным расстоянием и флагом равным нулю. Затем мы устанавливаем в ней флаг в 1 и проверяем все соседние с ней вершины *u*. Если в них (в *u*) расстояние больше, чем сумма расстояния до текущей вершины и длины ребра, то уменьшаем его. Цикл завершается, когда флаги всех вершин становятся равны 1, либо когда у всех вершин c флагом 0 *d[i] = \infty*. Последний случай возможен тогда и только тогда, когда граф G несвязный.

[**Спецификация**](https://github.com/justtomu/practice/blob/main/spec.md)

[**План разработки**](https://github.com/justtomu/practice/blob/main/development%20plan.md)

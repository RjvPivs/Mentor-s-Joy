package com.example.mentorsjoy.backend;

import com.example.mentorsjoy.model.SectionsPMI;
import com.example.mentorsjoy.model.SectionsRO;
import com.example.mentorsjoy.model.SectionsTP;
import com.example.mentorsjoy.model.SectionsTZ;
import com.example.mentorsjoy.model.SectionsPZ;

import java.util.Arrays;

public class SectionConverter {
    public static Section[] CallConverter(Object sections, String presetString) {
        switch (presetString) {
            case "TZ":
                return ConvertTZ((SectionsTZ) sections);
            case "PZ":
                return ConvertPZ((SectionsPZ) sections);
            case "TP":
                return ConvertTP((SectionsTP) sections);
            case "RO":
                return ConvertRO((SectionsRO) sections);
            case "PMI":
                return ConvertPMI((SectionsPMI) sections);
        }
        return new Section[1];
    }
    private static Section[] ConvertTZ(SectionsTZ sections) {
        Section[] res = new Section[8];
        //Введение
        res[0] = new Section(2);
        res[0].title = "ВВЕДЕНИЕ";
        res[0].subtitles[0] = "Наименование программы";
        res[0].subtitles[1] = "Краткая характеристика области применения";
        res[0].paragraphs[0] = String.format("Наименование темы разработки – «%s». Наименование темы разработки на английском языке – «%s».", sections.getProjectName() != null ? sections.getProjectName() : "", sections.getProjectNameEnglish() != null ? sections.getProjectNameEnglish() : "");
        res[0].paragraphs[1] = sections.getScope() != null ? sections.getScope() : "";
        //Основание
        res[1] = new Section(1);
        res[1].title = "ОСНОВАНИЯ ДЛЯ РАЗРАБОТКИ";
        res[1].subtitles[0] = "";
        res[1].paragraphs[0] = sections.getDocIncentive() != null ? sections.getDocIncentive() : "";
        //Назначение
        res[2] = new Section(2);
        res[2].title = "НАЗНАЧЕНИЕ РАЗРАБОТКИ";
        res[2].subtitles[0] = "Функциональное назначение";
        res[2].subtitles[1] = "Эксплуатационное назначени";
        res[2].paragraphs[0] = sections.getFunc() != null ? sections.getFunc() : "";
        res[2].paragraphs[1] = sections.getExp() != null ? sections.getExp() : "";
        //Требования
        res[3] = new Section(8);
        res[3].title = "ТРЕБОВАНИЯ К ПРОГРАММЕ";
        res[3].subtitles[0] = "Требования к функциональности";
        res[3].subtitles[1] = "Требования к интерфейсу";
        res[3].subtitles[2] = "Требования к надежности";
        res[3].subtitles[3] = "Условия эксплуатации";
        res[3].subtitles[4] = "Требования к составу и параметрам технических средств";
        res[3].subtitles[5] = "Требования к информационной и программной совместимости";
        res[3].subtitles[6] = "Требования к маркировке и упаковке";
        res[3].subtitles[7] = "Требования к транспортировке и хранению";
        res[3].paragraphs[0] = sections.getFunctions() != null ? sections.getFunctions() : "";
        res[3].paragraphs[1] = sections.getInter() != null ? sections.getInter() : "";
        res[3].paragraphs[2] = sections.getRobustness() != null ? sections.getRobustness() : "";
        res[3].paragraphs[3] = sections.getUser() != null ? sections.getUser() : "";
        res[3].paragraphs[4] = sections.getHardware() != null ? sections.getHardware() : "";
        res[3].paragraphs[5] = sections.getCompatability() != null ? sections.getCompatability() : "";
        res[3].paragraphs[6] = sections.getPackaging() != null ? sections.getPackaging() : "";
        res[3].paragraphs[7] = sections.getStorage() != null ? sections.getStorage() : "";
        //Требование к документации
        res[4] = new Section(1);
        res[4].title = "ТРЕБОВАНИЯ К ПРОГРАММНОЙ ДОКУМЕНТАЦИИ";
        res[4].subtitles[0] = "";
        res[4].paragraphs[0] = "Предварительный состав программной документации\n" +
                "1.«Генератор документации «Радость научника». Техническое задание (ГОСТ 19.201-78);\n" +
                "2.«Генератор документации «Радость научника». Программа и методика испытаний (ГОСТ 19.301-78);\n" +
                "3.«Генератор документации «Радость научника». Текст программы (ГОСТ 19.401-78);\n" +
                "4.«Генератор документации «Радость научника». Пояснительная записка (ГОСТ 19.404-79);\n" +
                "5.«Генератор документации «Радость научника Руководство оператора (ГОСТ 19.505-79).\n";
        //Экономические
        res[5] = new Section(3);
        res[5].title = "ОЖИДАЕМЫЕ ТЕХНИКО-ЭКОНОМИЧЕСКИЕ ПОКАЗАТЕЛИ";
        res[5].subtitles[0] = "Ориентировочная экономическая эффективность";
        res[5].subtitles[1] = "Предполагаемая потребность";
        res[5].subtitles[2] = "Экономические преимущества разработки по сравнению с отечественными или зарубежными аналогами";
        res[5].paragraphs[0] = "В рамках данной работы расчет экономической эффективности не предусмотрен.";
        res[5].paragraphs[1] = sections.getUsage() != null ? sections.getUsage() : "";
        res[5].paragraphs[2] = sections.getComparison() != null ? sections.getComparison() : "";
        //Стадии и этапы
        res[6] = new Section(0);
        res[6].title = "СТАДИИ И ЭТАПЫ РАЗРАБОТКИ";
        //Контроль и приёмка
        res[7] = new Section(2);
        res[7].title = "ПОРЯДОК КОНТРОЛЯ И ПРИЕМКИ";
        res[7].subtitles[0] = "Виды испытаний";
        res[7].subtitles[1] = "Общие требования к приемке работы";
        res[7].paragraphs[0] = sections.getTests() != null ? sections.getTests() : "";
        res[7].paragraphs[1] = sections.getAcceptance() != null ? sections.getAcceptance() : "";
        return res;
    }
    private static Section[] ConvertPZ(SectionsPZ sections) {
        Section[] res = new Section[4];
        //Введение
        res[0] = new Section(2);
        res[0].title = "ВВЕДЕНИЕ";
        res[0].subtitles[0] = "Наименование программы";
        res[0].subtitles[1] = "Документы, на основании которых ведётся разработка";
        res[0].paragraphs[0] = String.format("Наименование темы разработки – «%s».\nНаименование темы разработки на английском языке – «%s».", sections.getProjectName() != null ? sections.getProjectName() : "", sections.getProjectNameEnglish() != null ? sections.getProjectNameEnglish() : "");
        res[0].paragraphs[1] = String.format("Основанием для разработки является учебный план подготовки бакалавров по направлению %s и утвержденная академическим руководителем тема курсового проекта.", sections.getDocIncentive() != null ? sections.getDocIncentive() : "");
        //Назначение
        res[1] = new Section(3);
        res[1].title = "НАЗНАЧЕНИЕ И ОБЛАСТЬ ПРИМЕНЕНИЯ";
        res[1].subtitles[0] = "Функциональное назначение программы";
        res[1].subtitles[1] = "Эксплуатационное назначение программы";
        res[1].subtitles[2] = "Краткая характеристика области применения";
        res[1].paragraphs[0] = sections.getFunc() != null ? sections.getFunc() : "";
        res[1].paragraphs[1] = sections.getExp() != null ? sections.getExp() : "";
        res[1].paragraphs[2] = sections.getScope() != null ? sections.getScope() : "";
        //Технические
        res[2] = new Section(4);
        res[2].title = "ТЕХНИЧЕСКИЕ ХАРАКТЕРИСТИКИ";
        res[2].subtitles[0] = "Постановка задачи на разработку программы";
        res[2].subtitles[1] = "Описание алгоритма и функционирования программы";
        res[2].subtitles[2] = "Описание и обоснование выбора метода организации входных и выходных данных";
        res[2].subtitles[3] = "Описание и обоснование выбора метода выбора технических и программных средств";
        res[2].paragraphs[0] = sections.getTask() != null ? sections.getTask() : "";
        res[2].paragraphs[1] = sections.getAlgorithm() != null ? sections.getAlgorithm() : "";
        res[2].paragraphs[2] = sections.getIO() != null ? sections.getIO() : "";
        res[2].paragraphs[3] = sections.getHardware() != null ? sections.getHardware() : "";
        //Экономические
        res[3] = new Section(3);
        res[3].title = "ОЖИДАЕМЫЕ ТЕХНИКО-ЭКОНОМИЧЕСКИЕ ПОКАЗАТЕЛИ";
        res[3].subtitles[0] = "Ориентировочная экономическая эффективность";
        res[3].subtitles[1] = "Предполагаемая потребность";
        res[3].subtitles[2] = "Экономические преимущества разработки по сравнению с отечественными или зарубежными аналогами";
        res[3].paragraphs[0] = "В рамках данной работы расчет экономической эффективности не предусмотрен.";
        res[3].paragraphs[1] = sections.getUsage() != null ? sections.getUsage() : "";
        res[3].paragraphs[2] = sections.getComparison() != null ? sections.getComparison() : "";
        return res;
    }
    private static Section[] ConvertTP(SectionsTP sections) {
        Section[] res = new Section[2];
        //Введение
        res[0] = new Section(1);
        res[0].title = "ВВЕДЕНИЕ";
        res[0].paragraphs[0] = sections.getIntro() != null ? sections.getIntro() : "";
        //Текст
        String temp = sections.getSource() != null ? sections.getSource() : "";
        if (temp.startsWith("!")) {
            res[1] = spliceParagraph(temp.substring(1));
        } else {
            res[1] = new Section(1);
            res[1].paragraphs[0] = sections.getSource() != null ? sections.getSource() : "";
        }
        res[1].title = "ОПИСАНИЕ ФАЙЛОВ С ИСХОДНЫМ КОДОМ ПРОГРАММЫ";
        return res;
    }
    private static Section[] ConvertRO(SectionsRO sections) {
        Section[] res = new Section[4];
        //Введение
        res[0] = new Section(3);
        res[0].title = "НАЗНАЧЕНИЕ ПРОГРАММЫ";
        res[0].subtitles[0] = "Функциональное назначение программы";
        res[0].subtitles[1] = "Эксплуатационное назначение программы";
        res[0].subtitles[2] = "Состав функций";
        res[0].paragraphs[0] = sections.getFunc() != null ? sections.getFunc() : "";
        res[0].paragraphs[1] = sections.getExp() != null ? sections.getExp() : "";
        res[0].paragraphs[2] = sections.getFuncList() != null ? sections.getFuncList() : "";
        //Назначение
        res[1] = new Section(3);
        res[1].title = "УСЛОВИЯ ВЫПОЛНЕНИЯ ПРОГРАММЫ";
        res[1].subtitles[0] = "Минимальный состав аппаратурных средств";
        res[1].subtitles[1] = "Минимальный состав программных средст";
        res[1].subtitles[2] = "Требования к персоналу (пользователю)";
        res[1].paragraphs[0] = sections.getHardware() != null ? sections.getHardware() : "";
        res[1].paragraphs[1] = sections.getSoftware() != null ? sections.getSoftware() : "";
        res[1].paragraphs[2] = sections.getUser() != null ? sections.getUser() : "";
        //Технические
        res[2] = new Section(4);
        res[2].title = "ВЫПОЛНЕНИЕ ПРОГРАММЫ";
        res[2].subtitles[0] = "Загрузка программы";
        res[2].subtitles[1] = "Запуск программы";
        res[2].subtitles[2] = "Выполнение программы";
        res[2].subtitles[3] = "Завершение программы";
        res[2].paragraphs[0] = sections.getInstall() != null ? sections.getInstall() : "";
        res[2].paragraphs[1] = sections.getLaunch() != null ? sections.getLaunch() : "";
        res[2].paragraphs[2] = sections.getWork() != null ? sections.getWork() : "";
        res[2].paragraphs[3] = sections.getFuncList() != null ? sections.getFinish() : "";
        //Экономические
        res[3] = new Section(2);
        res[3].title = "СООБЩЕНИЯ ОПЕРАТОРУ";
        res[3].subtitles[0] = "Сообщения в ходе работы программы";
        res[3].subtitles[1] = "Сообщения об ошибках";
        res[3].paragraphs[0] = sections.getMsg() != null ? sections.getMsg() : "";
        res[3].paragraphs[1] = sections.getErrors() != null ? sections.getErrors() : "";
        return res;
    }
    private static Section[] ConvertPMI(SectionsPMI sections) {
        Section[] res = new Section[6];
        //Введение
        res[0] = new Section(2);
        res[0].title = "ОБЪЕКТ ИСПЫТАНИЙ";
        res[0].subtitles[0] = "Наименование программы";
        res[0].subtitles[1] = "Краткая характеристика области применения";
        res[0].paragraphs[0] = String.format("Наименование темы разработки – «%s». Наименование темы разработки на английском языке – «%s».", sections.getProjectName() != null ? sections.getProjectName() : "", sections.getProjectNameEnglish() != null ? sections.getProjectNameEnglish() : "");
        res[0].paragraphs[1] = sections.getScope() != null ? sections.getScope() : "";
        //Основание
        res[1] = new Section(1);
        res[1].title = "ЦЕЛЬ ИСПЫТАНИЙ";
        res[1].subtitles[0] = "";
        res[1].paragraphs[0] = sections.getTarget() != null ? sections.getTarget() : "";
        //Назначение
        res[2] = new Section(3);
        res[2].title = "ТРЕБОВАНИЯ К ПРОГРАММЕ";
        res[2].subtitles[0] = "Требования к функциональным характеристикам";
        res[2].subtitles[1] = "Требования к интерфейсу";
        res[2].subtitles[2] = "Требования к надежности";
        res[2].paragraphs[0] = sections.getFunctions() != null ? sections.getFunctions() : "";
        res[2].paragraphs[1] = sections.getInter() != null ? sections.getInter() : "";
        res[2].paragraphs[2] = sections.getRobustness() != null ? sections.getRobustness() : "";
        //Требования
        res[3] = new Section(1);
        res[3].title = "ТРЕБОВАНИЯ К ПРОГРАММНОЙ ДОКУМЕНТАЦИИ";
        res[3].paragraphs[0] = "Состав программной документации:\n" +
                "1) «Генератор документации «Радость научника»». Техническое задание (ГОСТ 19.201-78)\n" +
                "2) «Генератор документации «Радость научника»». Программа и методика испытаний (ГОСТ 19.301-79)\n" +
                "3) «Генератор документации «Радость научника»». Текст программы (ГОСТ 19.401-78)\n" +
                "4) «Генератор документации «Радость научника»». Пояснительная записка (ГОСТ 19.404-79)\n" +
                "5) «Генератор документации «Радость научника»». Руководство оператора (ГОСТ 19.505-79)\n";
        //Требование к документации
        res[4] = new Section(2);
        res[4].title = "СРЕДСТВА И ПОРЯДОК ИСПЫТАНИЙ";
        res[4].subtitles[0] = "Технические и программные средства, используемые во время испытаний";
        res[4].subtitles[1] = "Порядок проведения испытаний";
        res[4].paragraphs[0] = sections.getHardware() != null ? sections.getHardware() : "";
        res[4].paragraphs[1] = sections.getTestsOrder() != null ? sections.getTestsOrder() : "";
        //Экономические
        res[5] = new Section(4);
        res[5].title = "МЕТОДЫ ИСПЫТАНИЙ";
        res[5].subtitles[0] = "Испытания требований к программной документации";
        res[5].subtitles[1] = "Испытания требований к функциональным характеристикам";
        res[5].subtitles[2] = "Испытание требований к интерфейсу";
        res[5].subtitles[3] = "Испытания требований к надежности";
        res[5].paragraphs[0] = sections.getDocTests() != null ? sections.getDocTests() : "";
        res[5].paragraphs[1] = sections.getFuncTests() != null ? sections.getFuncTests() : "";
        res[5].paragraphs[2] = sections.getInterTests() != null ? sections.getInterTests() : "";
        res[5].paragraphs[3] = sections.getRobustTests() != null ? sections.getRobustTests() : "";
        return res;
    }
    private static Section spliceParagraph(String text) {
        String[] spliced = text.split("\n\n");
        Section res = new Section((spliced.length + 1) / 2);
        for (int i = 0; i < spliced.length; i++) {
            if (i % 2 == 0) {
                res.subtitles[i / 2] = spliced[i];
            } else {
                res.paragraphs[i / 2] = spliced[i];
            }
        }
        return res;
    }
}
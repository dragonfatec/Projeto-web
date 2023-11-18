package com.RP.ControleDeJornada.domain.entitys.excel;

import com.aspose.cells.*;
import lombok.NoArgsConstructor;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
public class Excel {

    public void criarExcel(List<SendTimeExport> sendTimeList){
        try {
            // Inicializar um objeto Workbook
            Workbook workbook = new Workbook();

            // Obtendo a referência da planilha
            Worksheet worksheet = workbook.getWorksheets().get(0);
            String[] cabecalho = new String[] { "Data_inicial", "Data_final", "Tipo_de_hora", "Centro_de_resultado", "Nome_usuario", "Email_usuario", "Cliente", "Verba_1601", "vVerba_1602", "Verba_809", "Verba_3000", "Verba_3001", "Justificativa", "Status"};
            // Exemplo com Lista de Objetos
            worksheet.getCells().importCustomObjects(
                    sendTimeList,
                    cabecalho, // propertyNames
                    true, // isPropertyNameShown
                    0, // firstRow
                    0, // firstColumn
                    sendTimeList.size(), // Number of objects to be exported
                    true, // insertRows
                    null, // dateFormatString
                    false // convertStringToNumber
            );

            // Definir estilos
            CellsFactory factory = new CellsFactory();
            Style style = factory.createStyle();
            style.setPattern(BackgroundType.SOLID);
            style.setForegroundColor(Color.getWhite());
            workbook.setDefaultStyle(style);

            // Definir estilos
            CellsFactory factoryHeader = new CellsFactory();
            Style styleHeader = factoryHeader.createStyle();
            styleHeader.setHorizontalAlignment(TextAlignmentType.CENTER);
            styleHeader.getFont().setColor(Color.getBlack());
            styleHeader.getFont().setBold(true);
            styleHeader.getFont().setSize(12);

            CellsFactory factoryStatus = new CellsFactory();
            Style styleStatus = factoryStatus.createStyle();
            styleStatus.setPattern(BackgroundType.SOLID);

//            CellsFactory factoryBorder = new CellsFactory();
//            Style styleSBorder = factoryBorder.createStyle();
//            styleSBorder.setBorder(BorderType.TOP_BORDER, CellBorderType.THICK, Color.getBlack());
//            styleSBorder.setBorder(BorderType.LEFT_BORDER, CellBorderType.THICK, Color.getBlack());
//            styleSBorder.setBorder(BorderType.RIGHT_BORDER, CellBorderType.THICK, Color.getBlack());
//            styleSBorder.setBorder(BorderType.BOTTOM_BORDER, CellBorderType.THICK, Color.getBlack());
//
//            StyleFlag flag = new StyleFlag();
//            flag.setBorders(true);

            // Para aplicar o Style do cabeçalho
            for (int i = 0; i < cabecalho.length; i++) {
                worksheet.getCells().get(0,i).setStyle(styleHeader);
            }

            // Para aplicar o Style no status das horas
            for (int i = 0; i < sendTimeList.size(); i++) {
                Color color;
                if(sendTimeList.get(i).getStatus().equals("APPROVED")){
                    color = Color.fromArgb(175,208,149);
                }
                else if(sendTimeList.get(i).getStatus().equals("WAITING")) {
                    color = Color.fromArgb(255,233,148);
                }
                else{
                    color = Color.fromArgb(255,84,41);
                }
                styleStatus.setForegroundColor(color);
                worksheet.getCells().get(i+1, cabecalho.length-1).setStyle(styleStatus);

//                worksheet.getCells().applyRowStyle(i+1, styleSBorder, flag);
            }

            ListObjectCollection listObjects = workbook.getWorksheets().get(0).getListObjects();
            listObjects.add(0, 0, sendTimeList.size(), cabecalho.length-1, true);

            workbook.save("/home/lukas/relatorio.xlsx");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

package com.RP.ControleDeJornada.domain.entitys.excel;

import com.aspose.cells.*;
import lombok.NoArgsConstructor;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
public class Excel {

    public void criarExcel(List<SendTimeExport> sendTimes){
        System.out.println("\n\nentrou no excel\n\n");
        try {
            // Inicializar um objeto Workbook
            Workbook workbook = new Workbook();

            // Obtendo a referência da planilha
            Worksheet worksheet = workbook.getWorksheets().get(0);
            String[] cabecalho = new String[] { "id", "data inicial", "data final", "tipo de hora", "centro de resultado", "nome usuario", "email", "cliente", "verba 1601", "verba 1602","verba 1809", "verba 3000", "verba 3001", "justificativa", "status", "status de aprovação" };
            // Exemplo com Lista de Objetos
            worksheet.getCells().importCustomObjects(sendTimes,
                    cabecalho, // propertyNames
                    true, // isPropertyNameShown
                    0, // firstRow
                    0, // firstColumn
                    sendTimes.size(), // Number of objects to be exported
                    true, // insertRows
                    null, // dateFormatString
                    false); // convertStringToNumber

            // Definir estilos
            CellsFactory factory = new CellsFactory();
            Style style = factory.createStyle();
            style.setHorizontalAlignment(TextAlignmentType.CENTER);
            style.getFont().setColor(Color.getBlack());
            style.getFont().setBold(true);
            style.getFont().setSize(12);

            for (int i = 0; i < cabecalho.length; i++) {
                worksheet.getCells().get(0,i).setStyle(style);
            }

            // Salvando o arquivo Excel
            workbook.save("/home/lukas/relatorio.xlsx");
        }
        catch (Exception e){
            System.out.println("\n\ndeu erro no excel\n\n");
            System.out.println(e);
        }
    }

    void criarPDF(){
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utbes;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author dion
 */
public class ImportDataset {

    Workbook workbook;
    Sheet sheet;

    public ImportDataset(String info) throws IOException, BiffException {
        workbook = Workbook.getWorkbook(new File(info));

    }

    //membuat graph dari hasil import
    public void Run(Graphs G) {

        sheet = workbook.getSheet(0);
        for (int i = 0; i < sheet.getRows(); i++) {
            for (int j = 0; j < sheet.getColumns(); j++) {
                Cell colArow1 = sheet.getCell(j, i);
                if (j != 1) {
                    if (!G.cekNode(colArow1.getContents())) {
                        Node n = new Node(colArow1.getContents());
                        G.addNode(n);
                    }
                    if (j == 2) {
                        G.addEdge(sheet.getCell(1, i).getContents(), sheet.getCell(0, i).getContents(), sheet.getCell(2, i).getContents());
                    }
                }
            }
        }
    }

}

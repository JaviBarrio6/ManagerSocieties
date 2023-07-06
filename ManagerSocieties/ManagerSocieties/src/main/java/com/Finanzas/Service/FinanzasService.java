package com.Finanzas.Service;

import com.Usuario.Entidad.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import java.text.DecimalFormat;

@Service
public class FinanzasService {

    ModelAndView finanzasModel = new ModelAndView();
    DecimalFormat df = new DecimalFormat("###.##");

    public ModelAndView finanzasModel (Usuario user, double ingresosVariables, double gastosFijos,
                                       double gastosVariables, double[] ingresosQ, String[] meses,
                                       String[][] ingresosPorCliente, double[] objetivos, String cuatrimestre,
                                       double[] objetivosQ){

        finanzasModel.setViewName("finanzas.html");
        finanzasModel.addObject("ingresosVariables", (ingresosVariables));
        finanzasModel.addObject("ingresosTotales", df.format(ingresosVariables));
        finanzasModel.addObject("gastosFijos", gastosFijos);
        finanzasModel.addObject("gastosVariables", gastosVariables);
        finanzasModel.addObject("gastosTotales", df.format(gastosFijos + gastosVariables));
        finanzasModel.addObject("balance", df.format(ingresosVariables - gastosFijos - gastosVariables));

        finanzasModel.addObject("objetivos", objetivos);
        finanzasModel.addObject("cuatrimestre", cuatrimestre);
        finanzasModel.addObject("objetivosQ", objetivosQ);

        finanzasModel.addObject("ingresosQ", ingresosQ);
        finanzasModel.addObject("meses", meses);

        finanzasModel.addObject("ingresosPorCliente", ingresosPorCliente);

        finanzasModel.addObject("usuario", user);
        return finanzasModel;
    }

    public String[][] obtenerGraficoCircular (String [][] ingresosPorCliente, double ingresosTotales){
        if (ingresosPorCliente.length > 5){
            String[][] graficoCirular = new String[5][2];
            double acumulado = 0;
            for (int i = 0; i <= 3; i++){
                graficoCirular[i][0] = ingresosPorCliente[i][3].concat(" ").concat(ingresosPorCliente[i][4]);
                acumulado += Double.valueOf(ingresosPorCliente[i][0]);
                graficoCirular[i][1] = Double.toString((Double.valueOf(ingresosPorCliente[i][0]) * 100) / ingresosTotales);
            }
            graficoCirular[4][0] = "Otros";
            graficoCirular[4][1] = Double.toString(100 - (acumulado * 100) / ingresosTotales);

            return graficoCirular;
        } else {
            String[][] graficoCirular = new String[ingresosPorCliente.length][2];
            for (int i = 0; i < ingresosPorCliente.length; i++){
                graficoCirular[i][0] = ingresosPorCliente[i][3].concat(" ").concat(ingresosPorCliente[i][4]);
                graficoCirular[i][1] = Double.toString((Double.valueOf(ingresosPorCliente[i][0]) * 100) / ingresosTotales);
            }
            return graficoCirular;
        }
    }

}

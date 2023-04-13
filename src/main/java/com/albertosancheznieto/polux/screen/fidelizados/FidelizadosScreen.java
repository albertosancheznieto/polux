package com.albertosancheznieto.polux.screen.fidelizados;

import com.albertosancheznieto.polux.app.FidelizadoService;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("polux_FidelizadosScreen")
@UiDescriptor("fidelizados-screen.xml")
public class FidelizadosScreen extends Screen {
    @Autowired
    private FidelizadoService fidelizadoService;

    @Subscribe("button_llamarService")
    public void onButton_llamarServiceClick(Button.ClickEvent event) {
        fidelizadoService.obtenerFidelizados();
    }
}
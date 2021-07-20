import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.net.URI;

public class EasyBuildOnline extends AnAction {

    private static final String ONLINE_URL = "https://service.zhenguanyu.com/deploy/?service=%s&env=Online&oper=deploy";

    @Override
    public void actionPerformed(AnActionEvent e) {
        String projectName = e.getProject().getName();
        try {
            URI uri = URI.create(String.format(ONLINE_URL, projectName));
            java.awt.Desktop dp = java.awt.Desktop.getDesktop();
            if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                dp.browse(uri);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

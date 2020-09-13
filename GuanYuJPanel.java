package SupermarketCashRegister;

import javax.swing.*;

/**
 * @Author: JinHe
 * @Date: 2020/6/15
 **/

public class GuanYuJPanel extends JPanel {
    // 构造方法
    public GuanYuJPanel(){
        initGUI();
    }
    // 初识界面的方法
    public void initGUI(){
        // 就只有一个jlabel，显示一张图片
        JLabel jl_guanyu = new JLabel();
        jl_guanyu.setIcon(new ImageIcon("src/images/logo.jpg"));
        // 将控件加到箱子中
        this.add(jl_guanyu);

    }
}

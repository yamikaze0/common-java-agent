package org.yamikaze.common.agent;

import java.lang.instrument.Instrumentation;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JVM Agent entrance.
 *
 * @author qinluo
 * @version 1.0.0
 * @date 2021-08-10 00:52
 */
public class AgentEntrance {

    /**
     * Agent entrance with JVM options -javaagent:<jar_path>.
     */
    public static void premain(String args, Instrumentation inst) {
        init(inst);
    }

    /**
     * Agent entrance with Java library API:
     * <code>
     *     VirtualMachine attachedVm = VirtualMachine.attach(String.valueOf(pid));
     *     attachedVm.loadAgent(agentJarPath);
     * </code>
     */
    public static void agentmain(String args, Instrumentation inst) {
        init(inst);
    }

    /**
     * Default init method.
     */
    private static void init(Instrumentation inst) {
        log();
        RuntimeInstHolder.init(inst);
    }

    private static void log() {
        Date now = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(f.format(now) + " common-java-agent loaded.");
    }
}

package org.yamikaze.common.agent;

import java.lang.instrument.Instrumentation;

/**
 * Runtime agent inst holder.
 *
 * @author qinluo
 * @version 1.0.0
 * @date 2021-08-10 00:59
 */
public class RuntimeInstHolder {

    /**
     * Singleton instance.
     */
    private static RuntimeInstHolder instance = null;

    /**
     * Current JVM inst.
     */
    private final Instrumentation inst;

    /**
     * Return singleton instance.
     */
    public static RuntimeInstHolder getInstance() {
        return instance;
    }

    /**
     * Return inst.
     */
    public Instrumentation getInst() {
        return inst;
    }

    /**
     * private constructor for singleton instance.
     */
    private RuntimeInstHolder(Instrumentation inst) {
        this.inst = inst;
    }

    /**
     * Default package permission.
     */
    static void init(Instrumentation inst) {
        if (inst == null) {
            throw new IllegalArgumentException("inst must not be null");
        }

        instance = new RuntimeInstHolder(inst);
    }
}

package org.jenkinsci.plugins.violationcolumns;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.model.Job;
import hudson.views.ListViewColumnDescriptor;
import hudson.views.ListViewColumn;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

public final class Pep8Column extends ListViewColumn {

    /**
     * The plugin descriptor.
     */
    private static final class Pep8ColumnDescriptor extends
            ListViewColumnDescriptor {
        @Override
        public String getDisplayName() {
            return "Violations pep8";
        }

        @Override
        public ListViewColumn newInstance(final StaplerRequest request,
                final JSONObject formData) throws FormException {
            return new Pep8Column();
        }

        @Override
        public boolean shownByDefault() {
            return false;
        }
    }

    /**
     * The plugin descriptor.
     */
    @Extension
    public static final Descriptor<ListViewColumn> DESCRIPTOR = new Pep8ColumnDescriptor();

    @Override
    public Descriptor<ListViewColumn> getDescriptor() {
        return DESCRIPTOR;
    }
    
   
    public String getViolations(Job<?, ?> job) {
        return Utils.getViolations(job, "pep8");
    }
}
